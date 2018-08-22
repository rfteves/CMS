package cms

import grails.gorm.transactions.Transactional

@Transactional
class ItemService<T extends Item> {
    T makeRecord(T record) {
        record.save(flush: true, failOnError: true)
    }
}
