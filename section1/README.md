# Section 1

## Prerequisites

* Installing openssl

## How to use

* cd to dir of ssh file
* run ssh file with first argument being the site you want to get the certificate expiration date from i.e google.com / ultimateqa.com 
* any site can be used

## How it was done

* I knew openssl could do the required taslk so that was my choice of tool
* I then proceeded to use Stackoverflow and openssl documentation in order to determine how to get the certicate of a website
* then located where the expiration date was located in the response from the command / in the certificate i.e between "not after:"  and "Subject"
* Then I proceeded to write a bash script that would accomplish the task 
* Comments were left on file on how this was accomplished

