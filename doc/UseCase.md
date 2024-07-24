@startuml

actor "Player" as pl

rectangle Instance {

    usecase "Search" as IS
    usecase "Go" as IG
    usecase "Leave" as IL
}

rectangle Mechanics {

    usecase "Start game" as MS
    usecase "Save game" as MSV
    usecase "Load game" as ML
    usecase "Exit game" as ME 
}


pl -> IS
pl -> IG
pl -> IL

pl -> MS
pl -> ML
pl -> MSV
pl -> ME
ME .> MSV : include

@enduml