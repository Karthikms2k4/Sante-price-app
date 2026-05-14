package com.sante.priceindex.data.local;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class PriceDao_Impl implements PriceDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<PriceEntity> __insertAdapterOfPriceEntity;

  public PriceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfPriceEntity = new EntityInsertAdapter<PriceEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `prices` (`id`,`commodity`,`modalPrice`,`market`,`district`,`state`,`arrivalDate`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final PriceEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCommodity() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getCommodity());
        }
        if (entity.getModalPrice() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getModalPrice());
        }
        if (entity.getMarket() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getMarket());
        }
        if (entity.getDistrict() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getDistrict());
        }
        if (entity.getState() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getState());
        }
        if (entity.getArrivalDate() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getArrivalDate());
        }
        statement.bindLong(8, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object insertPrices(final List<PriceEntity> prices,
      final Continuation<? super Unit> $completion) {
    if (prices == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfPriceEntity.insert(_connection, prices);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object getAllPrices(final Continuation<? super List<PriceEntity>> $completion) {
    final String _sql = "SELECT * FROM prices ORDER BY timestamp DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _cursorIndexOfCommodity = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "commodity");
        final int _cursorIndexOfModalPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "modalPrice");
        final int _cursorIndexOfMarket = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "market");
        final int _cursorIndexOfDistrict = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "district");
        final int _cursorIndexOfState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "state");
        final int _cursorIndexOfArrivalDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "arrivalDate");
        final int _cursorIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<PriceEntity> _result = new ArrayList<PriceEntity>();
        while (_stmt.step()) {
          final PriceEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_cursorIndexOfId));
          final String _tmpCommodity;
          if (_stmt.isNull(_cursorIndexOfCommodity)) {
            _tmpCommodity = null;
          } else {
            _tmpCommodity = _stmt.getText(_cursorIndexOfCommodity);
          }
          final String _tmpModalPrice;
          if (_stmt.isNull(_cursorIndexOfModalPrice)) {
            _tmpModalPrice = null;
          } else {
            _tmpModalPrice = _stmt.getText(_cursorIndexOfModalPrice);
          }
          final String _tmpMarket;
          if (_stmt.isNull(_cursorIndexOfMarket)) {
            _tmpMarket = null;
          } else {
            _tmpMarket = _stmt.getText(_cursorIndexOfMarket);
          }
          final String _tmpDistrict;
          if (_stmt.isNull(_cursorIndexOfDistrict)) {
            _tmpDistrict = null;
          } else {
            _tmpDistrict = _stmt.getText(_cursorIndexOfDistrict);
          }
          final String _tmpState;
          if (_stmt.isNull(_cursorIndexOfState)) {
            _tmpState = null;
          } else {
            _tmpState = _stmt.getText(_cursorIndexOfState);
          }
          final String _tmpArrivalDate;
          if (_stmt.isNull(_cursorIndexOfArrivalDate)) {
            _tmpArrivalDate = null;
          } else {
            _tmpArrivalDate = _stmt.getText(_cursorIndexOfArrivalDate);
          }
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_cursorIndexOfTimestamp);
          _item = new PriceEntity(_tmpId,_tmpCommodity,_tmpModalPrice,_tmpMarket,_tmpDistrict,_tmpState,_tmpArrivalDate,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getPricesByCommodity(final String commodity,
      final Continuation<? super List<PriceEntity>> $completion) {
    final String _sql = "SELECT * FROM prices WHERE commodity = ? ORDER BY timestamp DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (commodity == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, commodity);
        }
        final int _cursorIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _cursorIndexOfCommodity = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "commodity");
        final int _cursorIndexOfModalPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "modalPrice");
        final int _cursorIndexOfMarket = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "market");
        final int _cursorIndexOfDistrict = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "district");
        final int _cursorIndexOfState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "state");
        final int _cursorIndexOfArrivalDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "arrivalDate");
        final int _cursorIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<PriceEntity> _result = new ArrayList<PriceEntity>();
        while (_stmt.step()) {
          final PriceEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_cursorIndexOfId));
          final String _tmpCommodity;
          if (_stmt.isNull(_cursorIndexOfCommodity)) {
            _tmpCommodity = null;
          } else {
            _tmpCommodity = _stmt.getText(_cursorIndexOfCommodity);
          }
          final String _tmpModalPrice;
          if (_stmt.isNull(_cursorIndexOfModalPrice)) {
            _tmpModalPrice = null;
          } else {
            _tmpModalPrice = _stmt.getText(_cursorIndexOfModalPrice);
          }
          final String _tmpMarket;
          if (_stmt.isNull(_cursorIndexOfMarket)) {
            _tmpMarket = null;
          } else {
            _tmpMarket = _stmt.getText(_cursorIndexOfMarket);
          }
          final String _tmpDistrict;
          if (_stmt.isNull(_cursorIndexOfDistrict)) {
            _tmpDistrict = null;
          } else {
            _tmpDistrict = _stmt.getText(_cursorIndexOfDistrict);
          }
          final String _tmpState;
          if (_stmt.isNull(_cursorIndexOfState)) {
            _tmpState = null;
          } else {
            _tmpState = _stmt.getText(_cursorIndexOfState);
          }
          final String _tmpArrivalDate;
          if (_stmt.isNull(_cursorIndexOfArrivalDate)) {
            _tmpArrivalDate = null;
          } else {
            _tmpArrivalDate = _stmt.getText(_cursorIndexOfArrivalDate);
          }
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_cursorIndexOfTimestamp);
          _item = new PriceEntity(_tmpId,_tmpCommodity,_tmpModalPrice,_tmpMarket,_tmpDistrict,_tmpState,_tmpArrivalDate,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object clearAll(final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM prices";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
