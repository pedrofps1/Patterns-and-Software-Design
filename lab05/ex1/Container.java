public abstract class Container {
    protected Portion portion;

    public static Container create(Portion portion){
        Temperature t = portion.getTemperature();
        State estado = portion.getState();

        switch(t){
            case COLD:
                switch(estado){
                    case Liquid:
                        return new PlasticBottle(portion);
                    case Solid:
                        return new PlasticBag(portion);
                    default:
                        System.out.println("Erro");
                        return null;
                }
            case WARM:
                switch(estado){
                    case Liquid:
                        return new TermicBottle(portion);
                    case Solid:
                        return new Tupperware(portion);
                    default:
                        System.out.println("Erro");
                        return null;
                }
            default:
                throw new IllegalArgumentException("Invalid temperature: " + t);
        }
    }
}


