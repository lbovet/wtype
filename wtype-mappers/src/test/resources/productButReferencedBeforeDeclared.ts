// This is the same as product.ts, but Dimension is used before it is declared 

class Product {

    /**
     * The unique identifier for a product.
     */
    id: number;

    /**
     * Name of the product
     */
    name: string;

    price: number;

    tags: string[];

    dimension: Dimension;
}

class Dimension {
    length: number;
    width: number;
    height: number;
}
