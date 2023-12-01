#!/bin/bash

for i in $(seq 1 100)
do
   curl -I -X GET --location 'http://localhost:8080/test/' &
done
