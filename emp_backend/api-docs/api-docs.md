# employee-management-system-angular-spring-boot-mysql API Documentation

## Introduction

## getAllEmployees

`GET` /api/v1/employees

### Description

None

### Request Parameters

None

### Response

- Response Parameters. JSON array format description:

```json
[
  {
    "id": "integer //",
    "fname": "string //",
    "lname": "string //",
    "email": "string //",
    "salary": "integer //",
    "department": "string //",
    "designation": "string //",
    "joiningDate": "string //"
  }
]
```


## createEmployee

`POST` /api/v1/employees

### Description

None

### Request Parameters

- Body Parameters. JSON object format description:

```json
{
  "id": "integer //",
  "fname": "string //",
  "lname": "string //",
  "email": "string //",
  "salary": "integer //",
  "department": "string //",
  "designation": "string //",
  "joiningDate": "string //"
}
```

### Response

- Response Parameters. JSON object format description:

```json
{
  "id": "integer //",
  "fname": "string //",
  "lname": "string //",
  "email": "string //",
  "salary": "integer //",
  "department": "string //",
  "designation": "string //",
  "joiningDate": "string //"
}
```


## getByID

`GET` /api/v1/employees/{id}

### Description

None

### Request Parameters

- Path Parameters

| Field | Type | Required | Description |
| --- | --- | --- | --- |
| id | integer | Yes |  |

### Response

- Response Parameters. JSON object format description:

```json
{
  "id": "integer //",
  "fname": "string //",
  "lname": "string //",
  "email": "string //",
  "salary": "integer //",
  "department": "string //",
  "designation": "string //",
  "joiningDate": "string //"
}
```


## updateEmployeeByID

`PUT` /api/v1/employees/{id}

### Description

None

### Request Parameters

- Path Parameters

| Field | Type | Required | Description |
| --- | --- | --- | --- |
| id | integer | Yes |  |

- Body Parameters. JSON object format description:

```json
{
  "id": "integer //",
  "fname": "string //",
  "lname": "string //",
  "email": "string //",
  "salary": "integer //",
  "department": "string //",
  "designation": "string //",
  "joiningDate": "string //"
}
```

### Response

- Response Parameters. JSON object format description:

```json
{
  "id": "integer //",
  "fname": "string //",
  "lname": "string //",
  "email": "string //",
  "salary": "integer //",
  "department": "string //",
  "designation": "string //",
  "joiningDate": "string //"
}
```


## deleteEmployee

`DELETE` /api/v1/employees/{id}

### Description

None

### Request Parameters

- Path Parameters

| Field | Type | Required | Description |
| --- | --- | --- | --- |
| id | integer | Yes |  |

### Response

- Response Parameters. JSON object format description:

```json
{
  "MAP_KEY": "boolean //"
}
```


## getAllAdmins

`GET` /api/v1/admin

### Description

None

### Request Parameters

None

### Response

- Response Parameters. JSON array format description:

```json
[
  {
    "adminID": "integer //",
    "adminName": "string //",
    "adminPassword": "string //"
  }
]
```


