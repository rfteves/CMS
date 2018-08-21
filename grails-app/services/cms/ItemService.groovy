package cms

import grails.gorm.transactions.Transactional

@Transactional
class ItemService<R extends Item> {
    R makeRecord(R record) {
        record.save(flush: true)
    }
}
