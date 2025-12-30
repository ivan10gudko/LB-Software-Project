import { Outlet } from "react-router";
import Header from "../components/Header";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import Footer from "~/components/Footer";
import { ReactQueryDevtools } from '@tanstack/react-query-devtools'
import { queryClient } from "~/lib/queryClient";

function MainLayout() {
    

    return (
        <QueryClientProvider client={queryClient}>
            <div className="app font-industrial min-h-screen flex flex-col">
                <Header />
                <main className="flex-1">
                    <Outlet />
                </main>
                <Footer />
            </div>
            <ReactQueryDevtools initialIsOpen={false} />
        </QueryClientProvider>
    );
}

export default MainLayout;