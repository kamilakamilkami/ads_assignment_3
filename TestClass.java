public class TestClass {
    private String value;

    public TestClass(String value){
        this.value = value;
    }

    public int hashcode(){

        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash = 31 * hash + value.charAt(i);
        }
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestClass that = (TestClass) obj;
        return value == that.value;
    }
}
