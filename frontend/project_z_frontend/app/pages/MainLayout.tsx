import { Outlet } from "react-router";
import Header from "../components/Header";

function MainLayout() {
    return (
        <div className="app">
            <Header />
            <main>
                <Outlet />
            </main>
        </div>
    );
}

export default MainLayout;