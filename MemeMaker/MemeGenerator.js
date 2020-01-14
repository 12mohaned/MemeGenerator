db = db.getSiblingDB("MemeGenerator");
db.MemeGenerator.drop();
db.MemeGenerator.insertMany([
{"Name":"Drake","Image":"/Users/mohanedmashaly/MemeGenerator/MemeMaker/Featured-Memes/Drake.jpeg","Description":"A meme which shows how Drake react to two different objects for example something he loves and something he hates"},
{"Name":"Curious","Image":"/Users/mohanedmashaly/MemeGenerator/MemeMaker/Featured-Memes/Curious.jpg","Description" : "A meme which shows a person reading interesting information's"},
{"Name":"WTF","Image":"/Users/mohanedmashaly/MemeGenerator/MemeMaker/Featured-Memes/WTF.jpg","Description" : "A meme which shows a person reaction to a super weird situation"},
{"Name":"SpongeBob","Image":"/Users/mohanedmashaly/MemeGenerator/MemeMaker/Featured-Memes/SpongeBob.jpeg","Description" : "A meme which shows SpongeBob reaction to different situations"},
{"Name":"Mocking-Spongebob","Image":"/Users/mohanedmashaly/MemeGenerator/MemeMaker/Featured-Memes/Mocking-Spongebob.jpg","Description" : "A meme which Mocks Spongebob what a shame !"},
{"Name":"SpiderMan","Image":"/Users/mohanedmashaly/MemeGenerator/MemeMaker/Featured-Memes/SpiderMan.jpeg","Description" : "A meme which shows that a deep connection that two persons can be right at the same time"},
{"Name":"Expanding-Brain","Image":"/Users/mohanedmashaly/MemeGenerator/MemeMaker/Featured-Memes/Expanding-Brain.jpg","Description" : "A meme which shows Different level of intillgence"}
]);
