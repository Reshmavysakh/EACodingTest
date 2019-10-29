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
		"name": "Adrian Venti",
		"recordLabel": "Monocracy Records"
	}, {
		"name": "YOUKRANE",
		"recordLabel": "Anti Records"
	}]
}, {
	"name": "Small Night In",
	"bands": [{
		"name": "Green Mild Cold Capsicum",
		"recordLabel": "Marner Sis. Recording"
	}, {
		"name": "Squint-281",
		"recordLabel": "Outerscope"
	}, {
		"name": "The Black Dashes",
		"recordLabel": "Fourth Woman Records"
	}, {
		"name": "Yanke East",
		"recordLabel": "MEDIOCRE Music"
	}, {
		"name": "Wild Antelope",
		"recordLabel": "Marner Sis. Recording"
	}]
}]

RecordLabel    :ACR  
Band:Manish Ditch  
Music Festivals:Trainerella  

RecordLabel    :Still Bottom Records  
Band:Wild Antelope  
Music Festivals:Trainerella  

RecordLabel    :Monocracy Records  
Band:Adrian Venti  
Music Festivals:Trainerella  

RecordLabel    :Anti Records  
Band:YOUKRANE  
Music Festivals:Trainerella  

RecordLabel    :Marner Sis. Recording  
Band:Green Mild Cold Capsicum  
Music Festivals:Small Night In  

RecordLabel    :Outerscope  
Band:Squint-281  
Music Festivals:Small Night In  

RecordLabel    :Fourth Woman Records  
Band:The Black Dashes  
Music Festivals:Small Night In  

RecordLabel    :MEDIOCRE Music  
Band:Yanke East  
Music Festivals:Small Night In  

RecordLabel    :Marner Sis. Recording  
Band:Wild Antelope  
Music Festivals:Small Night In  
