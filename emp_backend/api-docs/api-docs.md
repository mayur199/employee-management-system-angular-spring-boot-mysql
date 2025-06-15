# employee-management-system-angular-spring-boot-mysql API Documentation

## Introduction

## Retrieves all employee records from the database.

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


## Creates a new employee record in the database.

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


## Retrieves an employee record by its ID.

`GET` /api/v1/employees/{id}

### Description

None

### Request Parameters

- Path Parameters

| Field | Type | Required | Description |
| --- | --- | --- | --- |
| id | integer | Yes | the ID of the employee to be retrieved. |

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


## Updates an existing employee record by its ID.

`PUT` /api/v1/employees/{id}

### Description

None

### Request Parameters

- Path Parameters

| Field | Type | Required | Description |
| --- | --- | --- | --- |
| id | integer | Yes | the ID of the employee to be updated. |

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


## Deletes an employee record by its ID.

`DELETE` /api/v1/employees/{id}

### Description

None

### Request Parameters

- Path Parameters

| Field | Type | Required | Description |
| --- | --- | --- | --- |
| id | integer | Yes | the ID of the employee to be deleted. |

### Response

- Response Parameters. JSON object format description:

```json
{
  "MAP_KEY": "boolean //"
}
```


## Retrieves all admin records from the database.

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


