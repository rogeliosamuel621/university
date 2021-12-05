package diccionario;

public class Dictionary {
    Record firstRecord;
    Record lastRecord;
    int length = 0;

    public void insert(Record newRecord) {
        if (this.length == 0) {
            this.firstRecord = newRecord;
            this.lastRecord = newRecord;
            this.upgradeLength();
            return;
        }

        this.lastRecord.next = newRecord;
        this.lastRecord = newRecord;
        this.upgradeLength();
    }

    public void showDictionary() {
        Record currentRecord = this.firstRecord;

        for(int i=0; i<this.length; i++) {
            System.out.println("Palabra: " + currentRecord.getWord());
            System.out.println("definicion: " + currentRecord.getDefinition());
            System.out.println();

            currentRecord = currentRecord.next;
        }
    }

    private void upgradeLength() {
        this.length++;
    }

    private void downgradeLength() {
        this.length--;
    }

}
