# EACodingTest
The Problem
Your team is tasked with listing out music festival data in a particular manner: at the top level, it should show the band record label, below that it should list out all bands under their management, and below that it should display which festivals they've attended, if any. All entries should be sorted alphabetically.

For example:

Record Label 1
Band X
Omega Festival
Band Y
Record Label 2
Band A
Alpha Festival
Beta Festival
The data is provided to you via an API by another team; they assure you all the data is available but it's in a different format and provide you with the Swagger documentation needed to get started.

Use this API as is to output the format specified above in any medium you desire; let it be a website, terminal, file or morse code if that's what you want to do - we just want to see the result somehow.

Sample jsonarray response and sorted Output

[{
	"name": "Trainerella",
	"bands": [{
		"name": "Manish Ditch",
		"recordLabel": "ACR"
	}, {
		"name": "Wild Antelope",
		"recordLabel": "Still Bottom Records"
	}, {
		"name": "YOUKRANE",
		"recordLabel": "Anti Records"
	}, {
		"name": "Adrian Venti",
		"recordLabel": "Monocracy Records"
	}]
}]

>recordLabel   :ACR  
>bands         :Manish Ditch  
>Musicfestivals:Trainerella  
>recordLabel   :Anti Records  
>bands         :YOUKRANE  
>Musicfestivals:Trainerella  
>recordLabel   :Monocracy Records  
>bands         :Adrian Venti  
>Musicfestivals:Trainerella  
>recordLabel   :Still Bottom Records  
>ands         :Wild Antelope  
>Musicfestivals:Trainerella  

Sample Output 2

Response code is: 200

JSON Response in String format
[{"name":"LOL-palooza","bands":[{"name":"Werewolf Weekday","recordLabel":"XS Recordings"},{"name":"Winter Primates","recordLabel":""},{"name":"Jill Black","recordLabel":"Fourth Woman Records"},{"name":"Frank Jupiter","recordLabel":"Pacific Records"}]},{"name":"Small Night In","bands":[{"name":"Squint-281","recordLabel":"Outerscope"},{"name":"Wild Antelope","recordLabel":"Marner Sis. Recording"},{"name":"Yanke East","recordLabel":"MEDIOCRE Music"},{"name":"The Black Dashes","recordLabel":"Fourth Woman Records"},{"name":"Green Mild Cold Capsicum","recordLabel":"Marner Sis. Recording"}]}]

RecordLabel    :  
Bands    :Winter Primates  
Music Festivals :LOL-palooza  
RecordLabel    :Fourth Woman Records  
Bands    :Jill Black  
Music Festivals :LOL-palooza  
RecordLabel    :Fourth Woman Records  
Bands    :The Black Dashes  
Music Festivals :Small Night In  
RecordLabel    :MEDIOCRE Music  
Bands    :Yanke East  
Music Festivals :Small Night In  
RecordLabel    :Marner Sis. Recording  
Bands    :Green Mild Cold Capsicum  
Music Festivals :Small Night In  
RecordLabel    :Marner Sis. Recording  
Bands    :Wild Antelope  
Music Festivals :Small Night In  
RecordLabel    :Outerscope  
Bands    :Squint-281  
Music Festivals :Small Night In  
RecordLabel    :Pacific Records  
Bands    :Frank Jupiter  
Music Festivals :LOL-palooza  
RecordLabel    :XS Recordings  
Bands    :Werewolf Weekday  
Music Festivals :LOL-palooza  
