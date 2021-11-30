# Caveat Emptor
## _Made with Spring Framework by Denizhan Aras_

Caveat Emptor is an online auction website which Users can register and bid to items.

- Made with Spring Framework
- REST API only (there is no Front-End)
- Tested with POSTMAN.
- Check controllers to see request URLs for testing purposes.

## Adding a category
- Post request with following body:

```
{
    "name": "Electronics"
}
```

## Adding a sub-category
- Post request with following body:

```
{
    "name": "Computers",
    "parentCategoryName": "Electronics"
}
```


## Adding an item
- Post request with following body:

```
{
    "name": "Apple MacBook Pro",
    "initialPrice": 10342,
    "auctionEnd": "2021-10-20",
    "images":[
        {
            "title": "Macbook1",
            "fileName": "mb1.jpeg"
        },
        {
            "title": "Macbook2",
            "fileName": "mb2.jpeg"
        }
    ],
    "categoryName": "Portable Computers",
    "sellerName": "denzhn"
}
```

## Adding a user
- Post request with following body:

```
{
    "userName": "denzhn",
    "firstName": "Denizhan",
    "lastName": "ARAS",
    "homeAddress":
    {
        "street": "Bilge Street",
        "zipcode": "34704",
        "city": "Istanbul",
        "type": "h"
    },
    "billingAddress":
    {
        "street": "Bilge Street",
        "zipcode": "34704",
        "city": "Istanbul",
        "type": "b"
    },
    "shippingAddress":
    {
        "street": "Bilge Street",
        "zipcode": "34704",
        "city": "Istanbul",
        "type": "s"
    }
}
```

## Adding a bid
- Post request with following body:
```
{
    "amount": 1105,
    "createdOn": "2021-10-13",
    "itemName": "Black Jacket",
    "username": "denzhn"
}
```

