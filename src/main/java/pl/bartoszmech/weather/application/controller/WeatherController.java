package pl.bartoszmech.weather.application.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.bartoszmech.weather.application.request.validator.RequestValidator;
import pl.bartoszmech.weather.application.response.WeatherResponse;
import pl.bartoszmech.weather.domain.weather.WeatherService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping( "/api/best-weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam("date") String date) {
        RequestValidator.validateDateFormat(date);
        return ResponseEntity.status(OK).body(weatherService.getBestLocation(date));
    }

}