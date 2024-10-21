import spock.lang.Specification

class FirstSpecification extends Specification {
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "two plus two should equal four"() {
        given:
        int left = 2
        int right = 2
        when:
        int result = left + right
        then:
        result == 4
    }

    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(0)
        then:
        list == [2, 3, 4]

    }
        /*
        ----------------FORÇAR A FALHA ------------------

        def "Should be able to remove from list"() {
            given:
            def list = [1, 2, 3, 4]

            when:
            list.remove(0)

            then:
            list == [1, 3, 4]  // Aqui esperamos uma lista incorreta para forçar a falha
        }

        ----------------OUTPUT------------------
        Condition not satisfied:

        list == [1, 3, 4]
        |    |
        |    false
        [2, 3, 4]
        */

    def "Should get an index out of bounds when removing a non-existent item"() {
        given:
        def list = [1, 2, 3, 4]
        when:
        list.remove(20)
        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c
        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }

    // Stub da classe PaymentGateway
    interface PaymentGateway {
        boolean makePayment(double amount)
    }

    def "Deve retornar false ao fazer um pagamento"() {
        given: "Um mock de PaymentGateway"
        def paymentGateway = Mock(PaymentGateway)

        when: "O método makePayment é invocado"
        def result = paymentGateway.makePayment(12.99)

        then: "O resultado deve ser false"
        result == false
    }

    interface Notifier {
        void sendNotification(String message)
    }

    def "Should verify notify was called"() {
        given: "Um mock de Notifier"
        def notifier = Mock(Notifier)

        when: "O método sendNotification é invocado"
        notifier.sendNotification('foo')

        then: "Verifica que o método foi chamado uma vez"
        1 * notifier.sendNotification('foo')
        // DEVE DAR ERRO
        //2 * notifier.notify('foo')

    }
}