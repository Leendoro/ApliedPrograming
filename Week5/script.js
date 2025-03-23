// async function getWeather() {
//     const apiKey = 'YOUR_API_KEY'; // Replace with your OpenWeatherMap API key
//     const location = document.getElementById('location').value;
//     const url = `https://api.openweathermap.org/data/2.5/weather?q=${location}&appid=${apiKey}&units=metric`;

//     try {
//         const response = await fetch(url);
//         const data = await response.json();

//         if (data.cod !== 200) {
//             document.getElementById('weather').innerHTML = `<p>${data.message}</p>`;
//             return;
//         }

//         document.getElementById('weather').innerHTML = `
//             <h2>${data.name}, ${data.sys.country}</h2>
//             <p>Temperature: ${data.main.temp}°C</p>
//             <p>Weather: ${data.weather[0].description}</p>
//             <p>Humidity: ${data.main.humidity}%</p>
//             <p>Wind Speed: ${data.wind.speed} m/s</p>
//         `;
//     } catch (error) {
//         document.getElementById('weather').innerHTML = '<p>Could not fetch weather data. Try again later.</p>';
//     }
// }


async function getWeather() {
    const apiKey = '4cf5f087255ee538e819b5171be7d818';

    const location = document.getElementById('location').value;

    try {
        if (!location) {
            throw new Error("Please enter a city name.");
        }

        const url = `https://api.openweathermap.org/data/2.5/weather?q=${location}&appid=${apiKey}&units=metric`;
        const response = await fetch(url);

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();

        if (data.cod !== 200) {
            throw new Error(data.message);
        }

        document.getElementById('weather').innerHTML = `
            <h2>${data.name}, ${data.sys.country}</h2>
            <p>Temperature: ${data.main.temp}°C</p>
            <p>Weather: ${data.weather[0].description}</p>
            <p>Humidity: ${data.main.humidity}%</p>
            <p>Wind Speed: ${data.wind.speed} m/s</p>
        `;
    } catch (error) {
        document.getElementById('weather').innerHTML = `<p style="color:red;">Error: ${error.message}</p>`;
    }
}
