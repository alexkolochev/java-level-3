package lesson_2.database;

import java.sql.*;
import java.util.Scanner;

public class DatabaseMain {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            fillTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        do {
            System.out.print("Введите команду: ");
            str = in.nextLine();
            String[] tokens = str.split(" ");

            if (tokens[0].equalsIgnoreCase("цена") && tokens.length >= 2) {
                try {
                    findProduct(tokens[1]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (tokens[0].equalsIgnoreCase("сменитьцену") && tokens.length >= 3) {
                try {
                    changeProduct(tokens[1], Integer.parseInt(tokens[2]));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (tokens[0].equalsIgnoreCase("товарыпоцене") && tokens.length >= 3) {
                try {
                    findProducts(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } while (!str.equalsIgnoreCase("end"));

        in.close();
        disconnect();
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void createTable() throws SQLException {
        stmt.execute("CREATE TABLE IF NOT EXISTS product (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "prodid INTEGER," +
                "title TEXT," +
                "cost INTEGER );");
        System.out.println("Таблица \"product\" успешно создана.");
    }

    public static void fillTable() throws SQLException {
        stmt.execute("DELETE FROM product;");
        stmt.executeUpdate("UPDATE SQLITE_SEQUENCE SET seq = 0 WHERE name = 'product';");

        connection.setAutoCommit(false);
        for (int i = 1; i <= 10000; i++) {
            stmt.executeUpdate("INSERT INTO product (prodid, title, cost)" +
                    "VALUES (" + i + ", 'товар" + i + "', " + (i * 10) + ");");
        }
        connection.setAutoCommit(true);

        System.out.println("Таблица \"product\" успешно заполнена данными.");
    }

    public static void findProduct(String title) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT cost FROM product " +
                "WHERE title = '" + title + "';");

        if (rs.isBeforeFirst()) {
            rs.next();
            System.out.println("Цена товара \"" + title + "\" равна " + rs.getInt(1));
        } else {
            System.out.println("Такого товара нет");
        }
    }

    public static void changeProduct(String title, int cost) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE title = '" + title + "';");

        if (rs.isBeforeFirst()) {
            stmt.executeUpdate("UPDATE product SET cost = " + cost + " WHERE title = '" + title + "';");
            System.out.println("Стоимость товара " + title + " была успешно изменена на значение " + cost);
        } else {
            System.out.println("Такого товара нет");
        }
    }


    public static void findProducts(int startCost, int endCost) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT title, cost FROM product " +
                "WHERE cost BETWEEN " + startCost + " AND " + endCost + ";");

        if (rs.isBeforeFirst()) {
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Список товаров в ценовом диапозоне от " + startCost + " до " + endCost + ":");

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i) + "\t\t\t");
            }

            System.out.println();

            while (rs.next()) {
                System.out.println(rs.getString("title") + "\t\t\t" + rs.getInt("cost"));
            }
        } else {
            System.out.println("Товары в заданном ценовом диапозоне не найдены");
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
