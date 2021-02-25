#!/bin/bash

# This is to check if arguments are supplied
if [ $# -eq 0 ]
  then
    echo "No arguments supplied, please specify url for ssl expiry date retrieval"
    exit 100
fi

# This runs the command to retrieve the ssl of the website and stored command output into variable
ssl_cert=`echo | openssl s_client -showcerts -servername $1 -connect $1:443 2>/dev/null | openssl x509 -inform pem -noout -text`

# this is regex to get a value between 2 strings
regex="Not After :(.*) Subject: "

# this run the reges and return first match to varable
[[ $ssl_cert =~ $regex ]] && found="${BASH_REMATCH[1]}"

# this prints result
echo "The site provided $1 expires after : $found"