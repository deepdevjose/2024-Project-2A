#include <DHT.h>

#define DHTPIN 2     // Pin al que está conectado el sensor
#define DHTTYPE DHT11   // Tipo de sensor DHT que estás utilizando

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  delay(2000);  // Esperar un momento entre lecturas

  float humidity = dht.readHumidity();
  float temperature = dht.readTemperature();

  Serial.print("Humedad: ");
  Serial.print(humidity);
  Serial.print("% - Temperatura: ");
  Serial.print(temperature);
  Serial.println("°C");
}
