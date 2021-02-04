# Deepak Mart Application: complete guide
I have created an Application named: Deepak Mart having role for Buyer, Seller, Admin and all are protected via oAuth2.0

## Building the project
You can use gradle wrapper which is configured in the project.

```
./gradlew clean build
```

## Running the application
You can use your IDE or command-line.

### IDE
Just run _DeekpakMartApplication_ as Java application.

### Command-line
You can use gradle for it.

```
gradlew clean bootRun
```

## SpringBoot profiles
* default - for local development, uses H2 in memory database, enabled by default

## Testing the application
Open Command Prompt

First, request an authentication token.
There are two users available.

Admin user:
```
curl -u my-client:my-secret -X POST http://localhost:8080/oauth/token -d "username=admin@gmail.com&password=iamadmin&grant_type=password"
```

Buyer user:
```
curl -u my-client:my-secret -X POST http://localhost:8080/oauth/token -d "username=buyer@gmail.com&password=iambuyer&grant_type=password"
```

If the above commands run successfully, we will get an authentication token in a response like below:

```
{"access_token":"a457df9f-b2cf-4530-8085-9b56ee4c6be2","token_type":"bearer","refresh_token":"5e70396e-f8f0-4fcf-b875-284bb4461137","scope":"read write trust"}```

Now, use the access_token to access the REST API.

```
curl -H "Authorization: Bearer a457df9f-b2cf-4530-8085-9b56ee4c6be2" http://localhost:8080/api/hello?name=Deepak

We will get the response like below
```
{"greetings":"Welcome Deepak (admin@gmail.com)!"}
```

We can see the list of Active tokens by calling the below command. Please update the access token before hitting.
```
curl -H "Authorization: Bearer 4ffbc510-1829-4e66-b598-9c237c83fbe9" http://localhost:8080/admin/token/list```
You should receive a list in a response.

You can also revoke the authentication token using the following endpoint.

```
curl -X DELETE -H "Authorization: Bearer 4ffbc510-1829-4e66-b598-9c237c83fbe9" http://localhost:8080/oauth/revoke
```