package ru.otus.homework7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class AbstractRepository<T> {
    private DataSource dataSource;
    private PreparedStatement psInsert;
    private List<Field> cachedFields;
    private Class<T> cls;

    public AbstractRepository(DataSource dataSource, Class<T> cls) {
        this.dataSource = dataSource;
        this.prepareInsert(cls);
        this.cls = cls;
    }

    public void save(T entity) {
        try {
            for (int i = 0; i < cachedFields.size(); i++) {
                psInsert.setObject(i + 1, cachedFields.get(i).get(entity));
            }
            psInsert.executeUpdate();
        } catch (Exception e) {
            throw new ORMException("Что-то пошло не так при сохранении: " + entity);
        }
    }

    private void prepareInsert(Class cls) {
        if (!cls.isAnnotationPresent(RepositoryTable.class)) {
            throw new ORMException("Класс не предназначен для создания репозитория, не хватает аннотации @RepositoryTable");
        }
        String tableName = ((RepositoryTable) cls.getAnnotation(RepositoryTable.class)).title();
        StringBuilder query = new StringBuilder("insert into ");
        query.append(tableName).append(" (");
        // 'insert into users ('
        cachedFields = Arrays.stream(cls.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(RepositoryField.class))
                .filter(f -> !f.isAnnotationPresent(RepositoryIdField.class))
                .collect(Collectors.toList());
        for (Field f : cachedFields) { // TODO заменить на использование геттеров
            f.setAccessible(true);
        }
        for (Field f : cachedFields) {
            query.append(getColumnName(f)).append(", ");
        }
        // 'insert into users (login, password, nickname, '
        query.setLength(query.length() - 2);
        query.append(") values (");
        // 'insert into users (login, password, nickname) values ('
        for (Field f : cachedFields) {
            query.append("?, ");
        }
        query.setLength(query.length() - 2);
        query.append(");");
        // 'insert into users (login, password, nickname) values (?, ?, ?);'
        try {
            psInsert = dataSource.getConnection().prepareStatement(query.toString());
        } catch (SQLException e) {
            throw new ORMException("Не удалось проинициализировать репозиторий для класса " + cls.getName());
        }
    }

    public <K> Optional<T> findById(K id) throws SQLException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!cls.isAnnotationPresent(RepositoryTable.class)) {
            throw new ORMException("Класс не предназначен для поиска по id, не хватает аннотации @RepositoryTable");
        }
        String tableName = ((RepositoryTable) cls.getAnnotation(RepositoryTable.class)).title();
        String query = "select * from " + tableName + " where id = " + id;
        System.out.println(query);
        ResultSet rs = dataSource.getStatement().executeQuery(query);

        if (rs.next()) {
            T instance = cls.getDeclaredConstructor().newInstance();
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                String columnName = getColumnName(field);
                Object value = rs.getObject(columnName);
                field.set(instance, value);
            }
            return (Optional<T>) Optional.of(instance);
        }
        return Optional.empty();
    }

    public List<T> findAll() throws SQLException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!cls.isAnnotationPresent(RepositoryTable.class)) {
            throw new ORMException("Класс не предназначен для поиска по id, не хватает аннотации @RepositoryTable");
        }
        String tableName = ((RepositoryTable) cls.getAnnotation(RepositoryTable.class)).title();
        String query = "select * from " + tableName;
        System.out.println(query);
        ResultSet rs = dataSource.getStatement().executeQuery(query);

        List<T> resultList = new ArrayList<>();

        while (rs.next()) {
            T instance = cls.getDeclaredConstructor().newInstance();
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                String columnName = getColumnName(field);
                Object value = rs.getObject(columnName);
                field.set(instance, value);
            }
            resultList.add(instance);
        }
        return resultList;
    }

    public void deleteById(long id) throws SQLException {
        if (!cls.isAnnotationPresent(RepositoryTable.class)) {
            throw new ORMException("Класс не предназначен для поиска по id, не хватает аннотации @RepositoryTable");
        }
        String tableName = ((RepositoryTable) cls.getAnnotation(RepositoryTable.class)).title();
        String query = "delete from " + tableName + " where id = " + id;
        System.out.println(query);
        boolean rs = dataSource.getStatement().execute(query);
    }

    public <V> void update(T entity, String field, V value) throws SQLException, NoSuchFieldException {
        if (!cls.isAnnotationPresent(RepositoryTable.class)) {
            throw new ORMException("Класс не предназначен для поиска по id, не хватает аннотации @RepositoryTable");
        }
        String tableName = ((RepositoryTable) cls.getAnnotation(RepositoryTable.class)).title();

        Object id;
        try {
            Field idField = cls.getDeclaredField("id");
            idField.setAccessible(true);
            id = idField.get(entity);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось получить значение поля 'id' у объекта", e);
        }

        if (id == null) {
            throw new ORMException("Значение поля 'id' у объекта не может быть null");
        }

        String columnName = getColumnName(cls.getDeclaredField(field));


        String query = "update " + tableName + " set " + columnName + " = '" + value + "' where id = " + id;
        System.out.println(query);
        dataSource.getStatement().executeUpdate(query);
    }


    public String getColumnName(Field field) {
        RepositoryField annotation = field.getAnnotation(RepositoryField.class);
        if (annotation != null && !annotation.columnName().isEmpty()) {
            return annotation.columnName();
        } else {
            return field.getName();
        }
    }
}
