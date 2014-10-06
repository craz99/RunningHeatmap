package testbed

class HelloController {

    def index() {
//		def gpsList = [new GPS(latitude:42.715103, longitude:-78.891551)]
		def gpsList = []
		(1..2).each { i ->
		  (1..2).each { j ->
			  double latitude = 42.715103 + (0.01*i)
			  double longitude = -78.891551 + (0.01*j)
			  gpsList << new GPS(latitude:latitude, longitude:longitude)
		  }
		}
		[ gpsList:gpsList ]
	}
	
	def hi() {
		render (view:'index.gsp')
	}
}
