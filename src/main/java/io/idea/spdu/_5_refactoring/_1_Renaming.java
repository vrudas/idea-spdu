package io.idea.spdu._5_refactoring;

public class _1_Renaming {

    public static void main(String[] args) {
        RenameMe renameMe = new RenameMe();

        System.out.println(renameMe.renameMe);

        String renameMeFieldValue = renameMe.getRenameMe();

        renameMe.renameMe();
    }

    private static class RenameMe {

        RenameMe() {

        }

        private String renameMe;

        public String getRenameMe() {
            return renameMe;
        }

        public void setRenameMe(String renameMe) {
            this.renameMe = renameMe;
        }

        public void renameMe() {

        }
    }
}
