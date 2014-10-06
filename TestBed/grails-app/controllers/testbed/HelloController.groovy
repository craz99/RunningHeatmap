package testbed

class HelloController {

    def index() {
		def gpsList = []
		(1..2).each { i ->
		  (1..2).each { j ->
			  double latitude = 42.715103 + (0.00001*i)
			  double longitude = -78.891551 + (0.00001*j)
			  gpsList << new GPS(latitude:latitude, longitude:longitude)
		  }
		}
		[ gpsList:gpsList ]
	}
	
	def hi() {
		render (view:'index.gsp')
	}
}
