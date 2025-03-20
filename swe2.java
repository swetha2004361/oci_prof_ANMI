document.getElementById('search-button').addEventListener('click', function() {
  const city = document.getElementById('city-input').value.trim();
  if (city) {
    getWeatherData(city);
  }
});

async function getWeatherData(city) {
  const apiKey = 'YOUR_API_KEY';  // Replace with your OpenWeatherMap API key
  const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;

  try {
    const response = await fetch(url);
    const data = await response.json();
    
    if (data.cod === '404') {
      alert('City not found!');
      return;
    }

    // Update the DOM with weather data
    document.getElementById('city-name').textContent = `City: ${data.name}`;
    document.getElementById('temperature').textContent = `Temperature: ${data.main.temp} °C`;
    document.getElementById('description').textContent = `Description: ${data.weather[0].description}`;
    document.getElementById('humidity').textContent = `Humidity: ${data.main.humidity} %`;
    document.getElementById('wind-speed').textContent = `Wind Speed: ${data.wind.speed} m/s`;
  } catch (error) {
    console.error('Error fetching data:', error);
    alert('Error fetching weather data. Please try again later.');
  }
}
