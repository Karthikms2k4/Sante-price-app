package com.sante.priceindex.data.local;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile PriceDao _priceDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(3, "1fc68a3bd12e9a79c9ee183fdbe943ea", "c5ebdbfad0569d837fc1f68ff91d186e") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `prices` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `commodity` TEXT NOT NULL, `modalPrice` TEXT NOT NULL, `market` TEXT NOT NULL, `district` TEXT NOT NULL, `state` TEXT NOT NULL, `arrivalDate` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1fc68a3bd12e9a79c9ee183fdbe943ea')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `prices`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsPrices = new HashMap<String, TableInfo.Column>(8);
        _columnsPrices.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrices.put("commodity", new TableInfo.Column("commodity", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrices.put("modalPrice", new TableInfo.Column("modalPrice", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrices.put("market", new TableInfo.Column("market", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrices.put("district", new TableInfo.Column("district", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrices.put("state", new TableInfo.Column("state", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrices.put("arrivalDate", new TableInfo.Column("arrivalDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPrices.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysPrices = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesPrices = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPrices = new TableInfo("prices", _columnsPrices, _foreignKeysPrices, _indicesPrices);
        final TableInfo _existingPrices = TableInfo.read(connection, "prices");
        if (!_infoPrices.equals(_existingPrices)) {
          return new RoomOpenDelegate.ValidationResult(false, "prices(com.sante.priceindex.data.local.PriceEntity).\n"
                  + " Expected:\n" + _infoPrices + "\n"
                  + " Found:\n" + _existingPrices);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "prices");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "prices");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PriceDao.class, PriceDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PriceDao priceDao() {
    if (_priceDao != null) {
      return _priceDao;
    } else {
      synchronized(this) {
        if(_priceDao == null) {
          _priceDao = new PriceDao_Impl(this);
        }
        return _priceDao;
      }
    }
  }
}
