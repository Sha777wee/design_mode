package com.shawee.design_mode.factory;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlDatabaseUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();;
        ICommand command = iDatabaseUtils.getCommand();
        command.command();

        iDatabaseUtils = new OracleDatabaseUtils();
        connection = iDatabaseUtils.getConnection();
        connection.connect();;
        command = iDatabaseUtils.getCommand();
        command.command();
    }
}

/*
    对于一个数据库操作工具类，
    变化的部分：
        数据库：mysql、oracle...
        连接
        指令
 */
interface IConnection {
    void connect();
}

class  MysqlConnection implements IConnection{
    @Override
    public void connect(){
        System.out.println("Mysql connection.");
    }
}

class  OracleConnection implements IConnection{
    @Override
    public void connect(){
        System.out.println("Oracle connection.");
    }
}

interface ICommand{
    void command();
}

class MysqlCommand implements ICommand {
    @Override
    public void command() {
        System.out.println("Mysql command.");
    }
}

class OracleCommand implements ICommand {
    @Override
    public void command() {
        System.out.println("Oracle command.");
    }
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

class OracleDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
