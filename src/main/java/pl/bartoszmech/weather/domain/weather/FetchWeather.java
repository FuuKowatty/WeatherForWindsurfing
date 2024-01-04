package pl.bartoszmech.weather.domain.weather;

import pl.bartoszmech.weather.infrastructure.fetch.FetchWeatherResponse;

import java.util.List;

public interface FetchWeather {
    List<FetchWeatherResponse> fetchFromLocalizations(List<String> urls);
}
