tResult <- readLines("C:/Users/sdedu/Desktop/Dev/FTP-Connection/Result/hResult.txt",encoding="UTF-8")

tResult <- strsplit(tResult,"\t")
tResult

tResult[[100]]
tResult[[100]][1]
tResult[[100]][2]

word = c()
count = c()

for (d in tResult){
  
  word[length(word) + 1] = d[1]
  count[length(count) + 1] = as.numeric(d[2])
  
}

word
count

dDF <- data.frame(word=word,count=count)
View(dDF)

install.packages("devtools")
library(devtools)

devtools::install_github("lchiffon/wordcloud2")
library(wordcloud2)

dDF <- dDF[order(-dDF$count),]
dDF

wordcloud2(dDF)
wordcloud2(dDF,size=5,fontFamily="D2Coding")
wordcloud2(dDF,size=5,fontFamily="D2Coding",color="random-light")
