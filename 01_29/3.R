tkResult <- readLines("C:/Users/sdedu/Desktop/tkResult/tkResult.txt",encoding="UTF-8")
tkResult <- strsplit(tkResult,"\t")

name = c()
nCount = c()

for (d in tkResult){
  
  name[length(name) + 1] = d[1]
  nCount[length(nCount) + 1] = as.numeric(d[2])
  
}

df2 <- data.frame(name=name,nCount=nCount)
View(df2)

barplot(df2$nCount,names.arg=df2$name,main="삼국지",xlab="인물",ylab="언급 횟수",col=c('#D1B2ff','#B5B2FF','#B2CCFF'))
pie(df2$nCount,labels=df2$name,main='삼국지',col=c('#D1B2ff','#B5B2FF','#B2CCFF'))
