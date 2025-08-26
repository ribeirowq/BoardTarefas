package application;

import application.persistence.migration.MigrationStrategy;
import application.ui.MainMenu;

import java.sql.SQLException;

import static application.persistence.config.ConnectionConfig.getConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        try(var connection = getConnection()){
            new MigrationStrategy().executeMigration();
        }
        new MainMenu().execute();
    }
}