package testbed



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class GPSController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond GPS.list(params), model:[GPSInstanceCount: GPS.count()]
    }

    def show(GPS GPSInstance) {
        respond GPSInstance
    }

    def create() {
        respond new GPS(params)
    }

    @Transactional
    def save(GPS GPSInstance) {
        if (GPSInstance == null) {
            notFound()
            return
        }

        if (GPSInstance.hasErrors()) {
            respond GPSInstance.errors, view:'create'
            return
        }

        GPSInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'GPS.label', default: 'GPS'), GPSInstance.id])
                redirect GPSInstance
            }
            '*' { respond GPSInstance, [status: CREATED] }
        }
    }

    def edit(GPS GPSInstance) {
        respond GPSInstance
    }

    @Transactional
    def update(GPS GPSInstance) {
        if (GPSInstance == null) {
            notFound()
            return
        }

        if (GPSInstance.hasErrors()) {
            respond GPSInstance.errors, view:'edit'
            return
        }

        GPSInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'GPS.label', default: 'GPS'), GPSInstance.id])
                redirect GPSInstance
            }
            '*'{ respond GPSInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(GPS GPSInstance) {

        if (GPSInstance == null) {
            notFound()
            return
        }

        GPSInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'GPS.label', default: 'GPS'), GPSInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'GPS.label', default: 'GPS'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
