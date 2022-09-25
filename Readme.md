# Build/run project and test the APIs

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/yeeh1616/IngAssignment.git
```

**2. Create PostgreSQL database**
```bash
create database ing01
```
- run `src/main/resources/ing01.sql`

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your postgresql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs

The app defines following CRUD APIs.

### Bags

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /bags | Get 3 bags | |
| GET    | /bags?bagsNum=n | Get n bags | |
| POST   | /bags | Add a bag | [JSON](#bagcreate) |

Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys

##### <a id="bagcreate">Create Bag -> /bags</a>
Note: supplier can be "ROYAL_GALA", "PINK_LADY", "KANZI_APPLE" or "ELSTAR_APPLES"
```json
{
  "applenum": 7,
  "supplier": "ROYAL_GALA",
  "time": "2022-09-24T20:10:02.890+00:00",
  "price": 3
}
```

![segment](https://api.segment.io/v1/pixel/track?data=ewogICJ3cml0ZUtleSI6ICJwcDJuOTU4VU1NT21NR090MWJXS0JQd0tFNkcydW51OCIsCiAgInVzZXJJZCI6ICIxMjNibG9nYXBpMTIzIiwKICAiZXZlbnQiOiAiQmxvZ0FwaSB2aXNpdGVkIiwKICAicHJvcGVydGllcyI6IHsKICAgICJzdWJqZWN0IjogIkJsb2dBcGkgdmlzaXRlZCIsCiAgICAiZW1haWwiOiAiY29tcy5zcHVyc0BnbWFpbC5jb20iCiAgfQp9)