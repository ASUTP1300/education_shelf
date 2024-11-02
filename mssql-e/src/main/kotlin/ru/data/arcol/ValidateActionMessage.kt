package ru.bee.arcollection.ivr.data.arcol


class ValidateActionMessage {
    companion object {

    enum class ValidateMessage(message: String) {
        VALIDATION_CONTRACT ("Активность не привязана к договору"),
        VALIDATION_CONTRACT_NUMBER ("Не указан номер договора"),
        VALIDATION_TEMPLATE ("У активности не указан шаблон IVR"),
        VALIDATION_SALE_POINT ("В договоре не указана точка продаж"),
        VALIDATION_MOSCOW_TIME_OFFSET ("В точке продаж не указан часовой пояс относительно МСК"),
        VALIDATION_COMMUNICATION_COUNT ("К договору не привязано ни одно средство связи c признаком \"Используется для IVR\""),
        VALIDATION_COMMUNICATION_NUMBER ("Не верный формат средства связи. Номер средства связи должен содержать 10 цифр"),
        VALIDATION_COMMON_DEBT_AMOUNT("В договоре нет счетов для обзвона"),
        VALIDATION_CURRENCY_ISO_DEBT_AMOUNT("Валюты нет в списке на стороне IP GT")
    }
    }
}

