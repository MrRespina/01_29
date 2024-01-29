# 데이터 받을용 c 생성
words = c()
counts = c()
wrs = c("손권","유비","조조")
crs = c(0,0,0)

# 1~10권 까지의 데이터 가져오기
for (i in 1:10){
  
  st = as.character(i)
  sets = "C:/Users/sdedu/Desktop/tkResult/tkTest"
  txt = ".txt"
  
  kResult <- readLines(paste0(sets,st,txt),encoding="UTF-8")
  kResult <- strsplit(kResult,"\t")
  
  for (d in kResult){
    
    words[length(words) + 1] = d[1]
    counts[length(counts) + 1] = as.numeric(d[2])
    
  }
  
}

# 손권/유비/조조 데이터 합산
arr = c(1,4,7,10,13,16,19,22,25,28)
for (i in arr){
  
  crs[1] = crs[1] + counts[i]
  crs[2] = crs[2] + counts[i+1]
  crs[3] = crs[3] + counts[i+2]
  
}

# df 생성
dDF <- data.frame(words=wrs,counts=crs)
View(dDF)

# 확인용
words
counts
wrs
crs

# 차트로 나타내기
barplot(crs,name=wrs)
pie(dDF$counts,labels=wrs)

barplot(dDF$counts,names.arg=dDF$words,main="삼국지",xlab="인물",ylab="언급 횟수",col=c('#D1B2ff','#B5B2FF','#B2CCFF'))
pie(dDF$counts,labels=dDF$words,main='삼국지',col=c('#D1B2ff','#B5B2FF','#B2CCFF'))
