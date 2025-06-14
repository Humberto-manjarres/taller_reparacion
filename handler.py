import json
import boto3
import os

dynamodb = boto3.resource('dynamodb', endpoint_url="http://host.docker.internal:4566")
table = dynamodb.Table("RepairServiceTable")  # tabla destino

def handler(event, context):
    for record in event["Records"]:
        body = json.loads(record["body"])
        print("Processing:", body)

        # Guardar en destino
        table.put_item(
            Item={
                "pk": f"EMPLOYEE#{body['identification']}_migrado",
                "sk": "PROFILE",
                "name": body["name"],
                "specialty": body["specialty"],
                "identification": body["identification"]
            },
            ConditionExpression="attribute_not_exists(pk)"
        )


    return {"statusCode": 200}
