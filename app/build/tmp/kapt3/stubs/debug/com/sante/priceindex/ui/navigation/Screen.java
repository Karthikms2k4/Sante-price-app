package com.sante.priceindex.ui.navigation;

@kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/sante/priceindex/ui/navigation/Screen;", "", "route", "", "<init>", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Login", "Signup", "Home", "Lcom/sante/priceindex/ui/navigation/Screen$Home;", "Lcom/sante/priceindex/ui/navigation/Screen$Login;", "Lcom/sante/priceindex/ui/navigation/Screen$Signup;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/sante/priceindex/ui/navigation/Screen$Home;", "Lcom/sante/priceindex/ui/navigation/Screen;", "<init>", "()V", "app_debug"})
    public static final class Home extends com.sante.priceindex.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.sante.priceindex.ui.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/sante/priceindex/ui/navigation/Screen$Login;", "Lcom/sante/priceindex/ui/navigation/Screen;", "<init>", "()V", "app_debug"})
    public static final class Login extends com.sante.priceindex.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.sante.priceindex.ui.navigation.Screen.Login INSTANCE = null;
        
        private Login() {
        }
    }
    
    @kotlin.Metadata(mv = {2, 1, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/sante/priceindex/ui/navigation/Screen$Signup;", "Lcom/sante/priceindex/ui/navigation/Screen;", "<init>", "()V", "app_debug"})
    public static final class Signup extends com.sante.priceindex.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.sante.priceindex.ui.navigation.Screen.Signup INSTANCE = null;
        
        private Signup() {
        }
    }
}