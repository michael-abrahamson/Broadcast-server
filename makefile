run:
	cd client-server && cd src && javac *.java && java Main

server:
	cd client-server && cd src && javac *.java && java Main start

client:
	cd client-server && cd src && javac *.java && java Main connect