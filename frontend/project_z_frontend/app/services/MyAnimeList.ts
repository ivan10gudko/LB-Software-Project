import axios from 'axios';
import type { Anime, SeacrchResponse } from './MyAnimeList.types';
import type { AnimeCardType } from '~/components/Card/AnimeCard';

export async function getTopAnimeList(): Promise<AnimeCardType[]> {
    try {
        const response = await axios.get("https://api.jikan.moe/v4/top/anime");
        const data = response.data.data;

        const animeList: AnimeCardType[] = data.map((item: any) => ({
            id: item.mal_id,
            title: item.title,
            score: item.score,
            img: item.images?.jpg?.image_url || "",
            year: item.year,
            episodes: item.episodes,
            genres: item.genres,
            airing: item.airing,
        }));

        return animeList;
    } catch (error) {
        console.error("Error fetching top anime:", error);
        return [];
    }
}

export async function getSeasonalAnimeList(): Promise<AnimeCardType[]> {
    try {
        const response = await axios.get("https://api.jikan.moe/v4/seasons/now");
        const data = response.data.data;

        const animeList: AnimeCardType[] = data.map((item: any) => ({
            id: item.mal_id,
            title: item.title,
            score: item.score,
            img: item.images?.jpg?.image_url || "",
            year: item.year,
            episodes: item.episodes,
            genres: item.genres,
            airing: item.airing,
        }));

        return animeList;
    } catch (error) {
        console.error("Error fetching seasonal anime:", error);
        return [];
    }
}


export async function getTopAnime(){

    const options = {
        method: 'GET',
        url: 'https://api.jikan.moe/v4/top/anime',
    };

    try {
	    const response = await axios.request(options);
	    return response.data.data[0];
    } catch (error) {
	    console.error(error);
    }
};

export async function getAnimeById(id:number){

    const options = {
        method: 'GET',
        url: `https://api.jikan.moe/v4/anime/${id}`
    };

    try {
	    const response = await axios.request(options);
	    return response.data.data;
    } catch (error) {
	    console.error(error);
    }
};

export async function getSeasonNow(){
    const options = {
        method: 'GET',
        url: `https://api.jikan.moe/v4/seasons/now`
    };

    try {
	    const response = await axios.request(options);
	    return response.data.data;
    } catch (error) {
	    console.error(error);
    }
}
export async function getRecentAnimeRecommendations(){
const options = {
    method: 'GET',
    url: 'https://api.jikan.moe/v4/recommendations/anime',

};

try {
	const response = await axios.request(options);
    console.log(response.data.data);
	return response.data.data;
    
} catch (error) {
	console.error(error);
}
};


export async function getAnimeSearch(q:string, page: number = 1):Promise<SeacrchResponse<AnimeCardType>>{
    
const options = {
    method: 'GET',
    url: 'https://api.jikan.moe/v4/anime',
    params: {
        q: q,
        page: page,
    }
};

try {
	const response = await axios.request(options);
	
    const data = response.data.data;

        const animeList: AnimeCardType[] = data.map((item: any) => ({
            id: item.mal_id,
            title: item.title,
            score: item.score,
            img: item.images?.jpg?.image_url || "",
            year: item.year,
            episodes: item.episodes,
            genres: item.genres,
            airing: item.airing,
        }));

        return {data:animeList,pagination:response.data.pagination}
} catch (error) {
	console.error(error);

    return {
            data: [],
            pagination: {
                last_visible_page: 0,
                has_next_page: false,
                current_page: 0,
                items: {
                    count: 0,
                    total: 0,
                    per_page: 0
                }
            }
        };
}
};