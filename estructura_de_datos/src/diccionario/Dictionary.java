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

    public Record getByword(String word) {
        Record currentRecord = this.firstRecord;

        for(int i=0; i<this.length; i++) {
            if (currentRecord.getWord().equals(word)) {
                return currentRecord;
            }

            currentRecord = currentRecord.next;
        }

        return null;
    }

    public void showRecord(Record record) {
        System.out.println("Palabra: " + record.getWord());
        System.out.println("definicion: " + record.getDefinition());
    }

    private void upgradeLength() {
        this.length++;
    }

    private void downgradeLength() {
        this.length--;
    }

}
