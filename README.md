# README #

# stackoverflow_per_user_summary

### What is this repository for? ###

This is to get some preliminary data per user, since the amount of users is quite large it became inpractical doing this locally in Excel and instead is easier to output into HDFS and then run a secondary job that build the histogram.

!!! For now this has only been done on Badges !!!

to run:
### ant clean dist ###
### hadoop jar dist/PerUser.jar PerUser /data/stackoverflow/Badges input ###
we want them in input as they'll be used again and otherwise would be overwritten.

Initial outputs included in the repo:

* badges_per_user.txt
* more to come...
