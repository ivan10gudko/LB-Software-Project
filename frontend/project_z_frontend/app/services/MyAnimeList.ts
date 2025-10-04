import axios from 'axios';

export async function getTopAnimeList(){

    const options = {
        method: 'GET',
        url: 'https://api.jikan.moe/v4/top/anime'
    };

    try {
	    const response = await axios.request(options);
	    console.log(response.data.data);
    } catch (error) {
	    console.error(error);
    }
};

export async function getTopAnime(){

    const options = {
        method: 'GET',
        url: 'https://api.jikan.moe/v4/top/anime',
    };

    try {
	    const response = await axios.request(options);
	    console.log(response.data.data[0]);
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
	    console.log(response.data.data);
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
	    console.log(response.data.data);
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
} catch (error) {
	console.error(error);
}
};


export async function getAnimeSearch(q:string){
const options = {
    method: 'GET',
    url: `https://api.jikan.moe/v4/anime?q=${q}`,

};

try {
	const response = await axios.request(options);
	console.log(response.data.data);
} catch (error) {
	console.error(error);
}
};