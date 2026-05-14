package com.sante.priceindex.data.local;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/sante/priceindex/data/local/PriceDao;", "", "getAllPrices", "", "Lcom/sante/priceindex/data/local/PriceEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPricesByCommodity", "commodity", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPrices", "", "prices", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAll", "app_debug"})
@androidx.room.Dao()
public abstract interface PriceDao {
    
    @androidx.room.Query(value = "SELECT * FROM prices ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllPrices(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.sante.priceindex.data.local.PriceEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM prices WHERE commodity = :commodity ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPricesByCommodity(@org.jetbrains.annotations.NotNull()
    java.lang.String commodity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.sante.priceindex.data.local.PriceEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertPrices(@org.jetbrains.annotations.NotNull()
    java.util.List<com.sante.priceindex.data.local.PriceEntity> prices, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM prices")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}