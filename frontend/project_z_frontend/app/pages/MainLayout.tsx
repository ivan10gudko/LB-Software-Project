import { Outlet } from "react-router";
import Header from "../components/Header";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

function MainLayout() {
    const queryClient = new QueryClient();
    return (
        <QueryClientProvider client={queryClient}>
            <div className="app font-industrial">
                <Header />
                <main>
                    <Outlet />
                </main>
            </div>
        </QueryClientProvider>
    );
}

export default MainLayout;