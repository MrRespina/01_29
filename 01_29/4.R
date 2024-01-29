library(dplyr)

bus <- read.csv("C:/Users/sdedu/Desktop/Dev/prac/bus/2021.csv",encoding="UTF-8")

View(bus)

year <- c(bus[1])
month <- c(bus[2])
day <- c(bus[3])
b_num <- c(bus[4])
b_locale <- c(bus[5])
b_load_count <- c(bus[6])
b_unload_count <- c(bus[7])
busDF = data.frame(year,month,day,b_num,b_locale,b_load_count,b_unload_count)
names(busDF) = c('year','month','day','b_num','b_locale','b_load_count','b_unload_count')
View(busDF)

for (i in 2:3){
  
  url <- paste0("C:/Users/sdedu/Desktop/Dev/prac/bus/202",i,".csv")
  bus <- read.csv(url,encoding="UTF-8")
  
  names(bus) <- names(busDF)
  busDF <- rbind(busDF,bus)
  
}

busDates = data.frame(bus[1],bus[2],bus[3])

View(busDates)

num <-  length(busDates$X2021)
View(num)

week = c()

for (i in 1:num){
  
  week[i] = as.Date(paste(busDates[i,1],busDates[i,2],busDates[i,3],sep="-"))
  
}

View(week)
View(weekdays())
