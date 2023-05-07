package com.example.mylibrary

class Simple01 {
    interface DB {
        fun save()
    }

    class SqlDB() : DB {
        override fun save() = println("save to sql")
    }

    class MySqlDB() : DB {
        override fun save() = println("save to MySqlDB")
    }

    class OracleDB() : DB {
        override fun save() = println("save to Oracle")
    }

    // 委托含义解释： 将接口的实现 委托给了参数db
    class CreateDBAction(db: DB) : DB by db
    /*
    public final class CreateDBAction implements DB {
       // $FF: synthetic field
       private final DB $$delegate_0;

       public CreateDBAction(@NotNull DB db) {
          Intrinsics.checkParameterIsNotNull(db, "db");
          super();
          this.$$delegate_0 = db;
       }

        @Override
        public void save() {
          this.$$delegate_0.save();
        }
    }
     */



}

fun main() {
    Simple01.CreateDBAction(Simple01.SqlDB()).save()
    Simple01.CreateDBAction(Simple01.OracleDB()).save()
    Simple01.CreateDBAction(Simple01.MySqlDB()).save()
}