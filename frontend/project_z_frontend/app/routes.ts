import {
    type RouteConfig,
    route,
    index,
    layout,
    prefix,
} from "@react-router/dev/routes";

export default [
    layout("./pages/MainLayout.tsx",[
    index("./pages/Home.tsx"),

    route("auth", "./pages/Auth.tsx"),

    route("profile/:id", "./pages/Profile.tsx"),

    ...prefix("rooms", [
    index("./pages/Rooms.tsx"),     // /rooms
    route(":id", "./pages/Room.tsx"), // /rooms/:id
    ]),

    route("search", "./pages/Search.tsx"),

    route("anime/:id", "./pages/AnimePage.tsx"),
    ]),
] satisfies RouteConfig;
