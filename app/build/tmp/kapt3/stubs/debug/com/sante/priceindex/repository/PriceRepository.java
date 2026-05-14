package com.sante.priceindex.repository;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0086@\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/sante/priceindex/repository/PriceRepository;", "", "priceDao", "Lcom/sante/priceindex/data/local/PriceDao;", "<init>", "(Lcom/sante/priceindex/data/local/PriceDao;)V", "getPricesForCommodities", "", "Lcom/sante/priceindex/data/model/PriceRecord;", "commodities", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PriceRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.sante.priceindex.data.local.PriceDao priceDao = null;
    
    public PriceRepository(@org.jetbrains.annotations.NotNull()
    com.sante.priceindex.data.local.PriceDao priceDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getPricesForCommodities(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> commodities, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.sante.priceindex.data.model.PriceRecord>> $completion) {
        return null;
    }
}